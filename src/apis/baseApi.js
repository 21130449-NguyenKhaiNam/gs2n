import axios from "axios";
import store from "../store";

const baseApi = axios.create({
  baseURL: "https://movienew.cybersoft.edu.vn/api/",
  headers: {
    TokenCybersoft:
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5Mb3AiOiJCb290Y2FtcCA1NSIsIkhldEhhblN0cmluZyI6IjI0LzA1LzIwNTAiLCJIZXRIYW5UaW1lIjoiMTcxNjUwODgwMDAwMCIsIm5iZiI6MTY4Nzg4NTIwMCwiZXhwIjoxNzE2NjU2NDAwfQ._c8SyKF5Fi2PgVWPPfYyvKMUVpCkteMNUebZfFUY3nU",
  },
});

baseApi.interceptors.request.use((config) => {
	const { accessToken } = store.getState().auth.user || {};

	if (accessToken) {
		config.headers.Authorization = `Bearer ${accessToken}`;
	}

	return config;
});

baseApi.interceptors.response.use(
	(response) => {
		return response.data.content;
	},
	(error) => {
		return Promise.reject(error.response?.data.content);
	}
);

export default baseApi;
