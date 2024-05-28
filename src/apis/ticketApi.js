import baseApi from "./baseApi";

const ticketApi = {
  // Danh sách phòng vé
  getTicketDetails: (ticketId) => {
    return baseApi.get("QuanLyDatVe/LayDanhSachPhongVe", {
      params: {
        MaLichChieu: ticketId,
      },
    });
  },

  // Tạo lịch chiếu
  addTheater: (showTimes) => {
    return baseApi.post("QuanLyDatVe/TaoLichChieu", showTimes);
  },

  bookingTicket: (infoBooking) => {
    return baseApi.post("QuanLyDatVe/DatVe", infoBooking);
  },
};

export default ticketApi;
