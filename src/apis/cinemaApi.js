import baseApi from "./baseApi";

const cinemaApi = {
  // Lấy thông tin lịch chiếu của hệ thống rạp
  getMovieSchedule: () => {
    return baseApi.get("QuanLyRap/LayThongTinLichChieuHeThongRap", {
      params: {
        maNhom: "GP03",
      },
    });
  },

  // Lấy thông tin lịch chiếu của bộ phim cụ thể
  getMovieScheduleDetails: (movieId) => {
    return baseApi.get("QuanLyRap/LayThongTinLichChieuPhim", {
      params: {
        MaPhim: movieId,
      },
    });
  },

  // Lấy thông tin chi tiết của hệ thống rạp
  getCinemaSystem: () => {
    return baseApi.get("QuanLyRap/LayThongTinHeThongRap");
  },

  // Lấy thông tin cụm rạp theo hệ thống
  getCinemaTheater: (theaterName) => {
    return baseApi.get("QuanLyRap/LayThongTinCumRapTheoHeThong", {
      params: {
        maHeThongRap: theaterName,
      },
    });
  },
};

export default cinemaApi;
