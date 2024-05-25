import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useDispatch } from "react-redux";
import swal from "sweetalert";
import { notification } from "antd";
import { updateUserClient } from "../../../Admin/slices/userSlice";
import "./userInfo.scss";

export default function UserInfo({ userInfo }) {
  const dispatch = useDispatch();

  useEffect(() => {
    reset({
      taiKhoan: userInfo?.taiKhoan,
      email: userInfo?.email,
      soDt: userInfo?.soDT,
      hoTen: userInfo?.hoTen,
      maLoaiNguoiDung: userInfo?.maLoaiNguoiDung,
    });
  }, [userInfo]);

  const {
    reset,
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    defaultValues: {
      taiKhoan: "",
      email: "",
      soDt: "",
      hoTen: "",
      maLoaiNguoiDung: "",
    },
    mode: "onTouched",
  });

  const onSubmit = async (values) => {
    console.log(values);
    try {
      await dispatch(updateUserClient(values)).unwrap();
      await swal("Cập Nhật Thành Công!", "You clicked the 'OK'!", "success");
    } catch (error) {
      notification.error({
        message: "Cập nhật thất bại",
        description: error,
      });
    }
  };

  return (
    <div className="user-update">
      <h1 className="user-title">Thông tin người dùng</h1>

      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="row">
          <div className="col-12 col-sm-12 col-md-12 col-lg-6">
            {/* tài khoản */}
            <div className="form-group mb-3">
              <label className="form-label">Tài Khoản</label>
              <input
                className="form-control"
                type="text"
                placeholder="Tài khoản"
                disabled
                {...register("taiKhoan", {
                  required: {
                    value: true,
                    message: "Tài khoản không được để trống",
                  },
                })}
              />
              {errors.taiKhoan && (
                <p className="text-danger">{errors.taiKhoan.message}</p>
              )}
            </div>

            {/* email */}
            <div className="form-group mb-3">
              <label className="form-label">Email</label>
              <input
                className="form-control"
                type="text"
                placeholder="Email"
                {...register("email", {
                  required: {
                    value: true,
                    message: "Email không được để trống",
                  },
                  pattern: {
                    value:
                      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                    message: "Email không đúng định dạng",
                  },
                })}
              />
              {errors.email && (
                <p className="text-danger">{errors.email.message}</p>
              )}
            </div>
          </div>

          <div className="col-12 col-sm-12 col-md-12 col-lg-6">
            {/* số điện thoại */}
            <div className="form-group mb-3">
              <label className="form-label">Số Điện Thoại</label>
              <input
                className="form-control"
                type="text"
                placeholder="Số điện thoại"
                {...register("soDt", {
                  required: {
                    value: true,
                    message: "Số điện thoại không được để trống",
                  },
                  pattern: {
                    value: /^[0-9]+$/,
                    message: "Vui lòng nhập số",
                  },
                })}
              />
              {errors.soDt && (
                <p className="text-danger">{errors.soDt.message}</p>
              )}
            </div>

            {/* họ tên */}
            <div className="form-group mb-3">
              <label className="form-label">Họ Tên</label>
              <input
                className="form-control"
                type="text"
                placeholder="Họ tên"
                {...register("hoTen", {
                  required: {
                    value: true,
                    message: "Họ tên không được để trống",
                  },
                })}
              />
              {errors.hoTen && (
                <p className="text-danger">{errors.hoTen.message}</p>
              )}
            </div>
          </div>
        </div>

        <div className="add-user-btn mt-3">
          <button className="btn btn-dark">Cập Nhật</button>
        </div>
      </form>
    </div>
  );
}
