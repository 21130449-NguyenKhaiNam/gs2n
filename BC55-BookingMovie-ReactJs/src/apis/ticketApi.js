import baseApi from "./baseApi";

const ticketApi = {
  getTicketDetails: (ticketId) => {
    return baseApi.get("QuanLyDatVe/LayDanhSachPhongVe", {
      params: {
        MaLichChieu: ticketId,
      },
    });
  },

  addTheater: (showTimes) => {
    return baseApi.post("QuanLyDatVe/TaoLichChieu", showTimes);
  },

  bookingTicket: (infoBooking) => {
    return baseApi.post("QuanLyDatVe/DatVe", infoBooking);
  },
};

export default ticketApi;
