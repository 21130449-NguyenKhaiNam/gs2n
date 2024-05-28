import baseApi from "./baseApi";

const userApi = {
  // Đăng nhập
  login: (values) => {
    return baseApi.post("QuanLyNguoiDung/DangNhap", values);
  },

  // Đăng ký
  register: (values) => {
    return baseApi.post("QuanLyNguoiDung/DangKy", {
      ...values,
      maNhom: "GP03",
    });
  },

  // Lấy danh sách user
  getUsers: () => {
    return baseApi.get("QuanLyNguoiDung/LayDanhSachNguoiDung", {
      params: {
        maNhom: "GP00",
      },
    });
  },

  // Lấy loại người dùng
  getUserType: () => {
    return baseApi.get("QuanLyNguoiDung/LayDanhSachLoaiNguoiDung");
  },

  // Thêm một người dùng
  addUser: (values) => {
    return baseApi.post("QuanLyNguoiDung/ThemNguoiDung", {
      ...values,
      maNhom: "GP00",
    });
  },

  // Loại bỏ một người dùng
  deleteUser: (account) => {
    return baseApi.delete("QuanLyNguoiDung/XoaNguoiDung", {
      params: {
        taiKhoan: account,
      },
    });
  },

  // Lấy thông tin chi tiết của một người dùng
  getUserDetails: (account) => {
    return baseApi.post("/QuanLyNguoiDung/LayThongTinNguoiDung", {
      params: {
        taiKhoan: account,
      },
    });
  },

  // Cập nhật thông tin của người dùng
  updateUser: (values) => {
    console.log(values);
    return baseApi.post("QuanLyNguoiDung/CapNhatThongTinNguoiDung", {
      ...values,
      maNhom: "GP03",
    });
  },

  // Cập nhật thông tin người dùng cho local stogare
  updateUserClient: (values) => {
    console.log(values);
    return baseApi.put("QuanLyNguoiDung/CapNhatThongTinNguoiDung", {
      ...values,
      maNhom: "GP03",
    });
  },

  // Tìm kiếm người dùng
  searchUser: (value) => {
    return baseApi.get("QuanLyNguoiDung/TimKiemNguoiDung", {
      params: {
        maNhom: "GP00",
        tuKhoa: value,
      },
    });
  },

  // Thông tin tài khoản
  getUserInfo: () => {
    return baseApi.post("QuanLyNguoiDung/ThongTinTaiKhoan");
  },
};

export default userApi;
