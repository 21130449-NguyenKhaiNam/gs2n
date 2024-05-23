import { useState, useMemo, useEffect, useRef } from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import { Pagination, Navigation, Autoplay } from "swiper/modules";
import { AiOutlineClose, AiOutlinePlayCircle } from "react-icons/ai";
import ReactPlayer from "react-player/lazy";
import { HashLoader } from "react-spinners";
import movieApi from "../../../../apis/movieApi";
import useRequest from "../../../../hooks/useRequest";
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";
import "./banner.scss";

const TRAILERS = [
  "https://www.youtube.com/watch?v=uoKSzOuPcfY",
  "https://www.youtube.com/watch?v=kBY2k3G6LsM&t",
  "https://youtu.be/t7WC5CJcy58?si=mO0OOiISarWKcmgE",
];

export default function Banner() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [video, setVideo] = useState("");
  const [playVideo, setPlayVideo] = useState(false);

  const showModal = (trailer) => {
    setIsModalOpen(true);
    setVideo(trailer);
    setPlayVideo(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
    setVideo("");
  };

  const { data: banners, isLoading } = useRequest(movieApi.getBanners);

  const bannersMapped = banners?.map((banner, index) => {
    return { ...banner, trailer: TRAILERS[index] };
  });

  const bannerMap = useMemo(() => {
    return bannersMapped?.map((banner, index) => (
      <SwiperSlide key={index}>
        <img src={banner.hinhAnh} alt={`banner-${banner.maBanner}`} />
        <button
          className="banner-icon-play"
          onClick={() => showModal(banner.trailer)}
        >
          <AiOutlinePlayCircle />
        </button>
      </SwiperSlide>
    ));
  }, [bannersMapped]);

  const CreateSwiper = () => {
    const [isLoaded, setIsLoaded] = useState(false);
    const swiperRef = useRef(null);

    useEffect(() => {
      setIsLoaded(true);
    }, []);

    const slideToIndex = (index) => {
      if (swiperRef.current) {
        swiperRef.current.slideTo(index);
      }
    };

    if (!isLoaded) {
      return <div>Loading...</div>; // Hiển thị một thông báo hoặc spinner trong quá trình tải
    }

    return (
      <Swiper
        ref={swiperRef} // Lưu trữ tham chiếu của Swiper vào biến ref
        slidesPerView={1}
        spaceBetween={30}
        loop={true}
        autoplay={{
          delay: 5000,
          disableOnInteraction: false,
          pauseOnMouseEnter: true,
        }}
        pagination={{
          clickable: true,
        }}
        navigation={true}
        initialSlide={0}
        modules={[Autoplay, Pagination, Navigation]}
        className="mySwiper"
      >
        {bannerMap}
      </Swiper>
    );
  };

  return (
    <div className="banner">
      <CreateSwiper />

      <div style={{ display: isModalOpen ? "block" : "none" }} className="main">
        <div className="banner-overlay" onClick={closeModal}></div>

        <div className="banner-modal">
          <div className="model-close" onClick={closeModal}>
            <button>
              <AiOutlineClose />
            </button>
          </div>
          <ReactPlayer playing={playVideo} controls url={video} />
        </div>
      </div>

      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "50px",
        }}
      >
        <HashLoader
          style={{
            margin: "0 auto",
            borderColor: "#fff",
            display: "block",
          }}
          color={"red"}
          loading={isLoading}
          size={30}
        />
      </div>
    </div>
  );
}
