import baseApi from "./baseApi";

const movieApi = {
  getBanners: () => {
    return baseApi.get("QuanLyPhim/LayDanhSachBanner");
  },

  // giang getMovie()
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

  // Giang getMovieDetails()
  getMovieDetails: (movieId) => {
    return baseApi.get("QuanLyPhim/LayThongTinPhim", {
      params: {
        maPhim: movieId,
      },
    });
  },

  addMovie: (movie) => {
    const formData = new FormData();

    for (let key in movie) {
      formData.append(key, movie[key]);
    }
    formData.append("maNhom", "GP03");

    return baseApi.post("QuanLyPhim/ThemPhimUploadHinh", formData);
  },

  deleteMovie: (movieId) => {
    return baseApi.delete("QuanLyPhim/XoaPhim", {
      params: {
        maPhim: movieId,
      },
    });
  },

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
