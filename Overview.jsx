import React from "react";
import { Rate, Progress } from "antd";
import movieApi from "../../../../apis/movieApi";
import useRequest from "../../../../hooks/useRequest";
import ErrorPage from "../../../Error/pages/ErrorPage"; 
import "./overview.scss";

export default function Overview({ movieId }) {
  // Sử dụng hook useRequest để lấy chi tiết phim từ API dựa trên movieId
  const { data: movie, error } = useRequest(() => movieApi.getMovieDetails(movieId));

  // Nếu có lỗi, hiển thị ErrorPage
  if (error) {
    return <ErrorPage />;
  }

  // Nếu không có dữ liệu phim, trả về null (không hiển thị gì)
  if (!movie) {
    return null;
  }

  return (
    <div className="overview">
      {/* Nền của phần tổng quan phim */}
      <div
        className="overview-background"
        style={{
          background: `url(${movie.hinhAnh}) center / cover no-repeat`,
        }}
      ></div>

      <div className="overview-film">
        <div className="overview-title">
          <div className="overview-img">
            <img
              src={movie.hinhAnh}
              alt={movie.maPhim}
              width="300px"
              height="400px"
            />
            {/* Đánh giá sao cho giao diện di động */}
            <Rate
              className="start-img-mobile"
              allowHalf
              count={5}
              defaultValue={movie.danhGia / 2}
              disabled
            />
          </div>

          <div className="overview-info">
            {/* Trạng thái của phim: Đang chiếu hoặc Sắp chiếu */}
            {movie?.dangChieu ? (
              <span className="overview-showing">Đang Chiếu</span>
            ) : movie?.sapChieu ? (
              <span className="overview-coming-soon">Sắp Chiếu</span>
            ) : null}
            <h3 className="overview-name">{movie.tenPhim}</h3>
            <div className="overview-scroll">
              <p className="overview-sub">{movie.moTa}</p>
            </div>
            <a href="#showtimes" className="overview-ticket">
              Mua Vé
            </a>
          </div>
        </div>

        {/* Phần đánh giá phim */}
        <div className="overview-rating">
          <div className="overview-progress">
            <Progress
              type="circle"
              strokeColor={{
                "0%": "#108ee9",
                "10%": "#87d068",
              }}
              format={(percent) => (
                <span className="overview-percent">{percent}</span>
              )}
              percent={movie.danhGia * 10}
            />
          </div>
          <div className="overview-start">
            {/* Đánh giá sao cho giao diện desktop */}
            <Rate
              className="start-desktop"
              count={10}
              defaultValue={movie.danhGia}
              disabled
            />
            {/* Đánh giá sao cho giao diện di động */}
            <Rate
              className="start-mobile"
              allowHalf
              count={5}
              defaultValue={movie.danhGia / 2}
              disabled
            />
          </div>
        </div>
      </div>
    </div>
  );
}
