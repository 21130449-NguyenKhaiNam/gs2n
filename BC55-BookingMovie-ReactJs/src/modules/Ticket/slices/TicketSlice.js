import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import ticketApi from "../../../apis/ticketApi";

const initialState = {
	tickets: [],
	isLoading: null,
	error: false,
};

export const bookingTicket = createAsyncThunk(
	"home/ticket/booking",
	async (infoBooking, { rejectWithValue }) => {
		try {
			await ticketApi.bookingTicket(infoBooking);
		} catch (error) {
			return rejectWithValue(error);
		}
	}
);

const TicketSlice = createSlice({
	name: "home/ticket",
	initialState,
	reducers: {},
});

export default TicketSlice.reducer;
