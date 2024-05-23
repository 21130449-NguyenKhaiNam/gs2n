import baseApi from "./baseApi";

const cinemaApi = {
  getMovieSchedule: () => {
    return baseApi.get("QuanLyRap/LayThongTinLichChieuHeThongRap", {
      params: {
        maNhom: "GP03",
      },
    });
  },

  getMovieScheduleDetails: (movieId) => {
    return baseApi.get("QuanLyRap/LayThongTinLichChieuPhim", {
      params: {
        MaPhim: movieId,
      },
    });
  },

  getCinemaSystem: () => {
    return baseApi.get("QuanLyRap/LayThongTinHeThongRap");
  },

  getCinemaTheater: (theaterName) => {
    return baseApi.get("QuanLyRap/LayThongTinCumRapTheoHeThong", {
      params: {
        maHeThongRap: theaterName,
      },
    });
  },
};

export default cinemaApi;
