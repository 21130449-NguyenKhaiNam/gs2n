import baseApi from "./baseApi";

const userApi = {
  login: (values) => {
    return baseApi.post("QuanLyNguoiDung/DangNhap", values);
  },

  register: (values) => {
    return baseApi.post("QuanLyNguoiDung/DangKy", {
      ...values,
      maNhom: "GP03",
    });
  },

  getUsers: () => {
    return baseApi.get("QuanLyNguoiDung/LayDanhSachNguoiDung", {
      params: {
        maNhom: "GP00",
      },
    });
  },

  getUserType: () => {
    return baseApi.get("QuanLyNguoiDung/LayDanhSachLoaiNguoiDung");
  },

  addUser: (values) => {
    return baseApi.post("QuanLyNguoiDung/ThemNguoiDung", {
      ...values,
      maNhom: "GP00",
    });
  },

  deleteUser: (account) => {
    return baseApi.delete("QuanLyNguoiDung/XoaNguoiDung", {
      params: {
        taiKhoan: account,
      },
    });
  },

  getUserDetails: (account) => {
    return baseApi.post("/QuanLyNguoiDung/LayThongTinNguoiDung", {
      params: {
        taiKhoan: account,
      },
    });
  },

  updateUser: (values) => {
    console.log(values);
    return baseApi.post("QuanLyNguoiDung/CapNhatThongTinNguoiDung", {
      ...values,
      maNhom: "GP03",
    });
  },

  updateUserClient: (values) => {
    console.log(values);
    return baseApi.put("QuanLyNguoiDung/CapNhatThongTinNguoiDung", {
      ...values,
      maNhom: "GP03",
    });
  },

  searchUser: (value) => {
    return baseApi.get("QuanLyNguoiDung/TimKiemNguoiDung", {
      params: {
        maNhom: "GP00",
        tuKhoa: value,
      },
    });
  },

  getUserInfo: () => {
    return baseApi.post("QuanLyNguoiDung/ThongTinTaiKhoan");
  },
};

export default userApi;
