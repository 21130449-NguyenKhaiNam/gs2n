import baseApi from "./baseApi";

const movieApi = {
  // Lấy banner
  getBanners: () => {
    return baseApi.get("QuanLyPhim/LayDanhSachBanner");
  },

  // Lấy danh sách phim
  getMovies: (search) => {
    if (search !== "") {
      return baseApi.get("QuanLyPhim/LayDanhSachPhim", {
        params: {
          maNhom: "GP03",
          tenPhim: search,
        },
      });
    }
    return baseApi.get("QuanLyPhim/LayDanhSachPhim", {
      params: {
        maNhom: "GP03",
      },
    });
  },

  // Lấy thông tin chi tiết của bộ phim
  getMovieDetails: (movieId) => {
    return baseApi.get("QuanLyPhim/LayThongTinPhim", {
      params: {
        maPhim: movieId,
      },
    });
  },

  // Thêm một bộ phim vào hệ thống
  addMovie: (movie) => {
    const formData = new FormData();

    for (let key in movie) {
      formData.append(key, movie[key]);
    }
    formData.append("maNhom", "GP03");

    return baseApi.post("QuanLyPhim/ThemPhimUploadHinh", formData);
  },

  // Loại bỏ một bộ phim khỏi ứng dụng
  deleteMovie: (movieId) => {
    return baseApi.delete("QuanLyPhim/XoaPhim", {
      params: {
        maPhim: movieId,
      },
    });
  },

  // Cập nhật thông tin cho phim
  updateMovie: (movie) => {
    const formData = new FormData();

    for (let key in movie) {
      formData.append(key, movie[key]);
    }
    formData.append("maNhom", "GP03");

    return baseApi.post("QuanLyPhim/CapNhatPhimUpload", formData);
  },
};

export default movieApi;
