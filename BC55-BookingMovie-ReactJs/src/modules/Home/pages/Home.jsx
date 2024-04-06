import React from "react";
import GoToTop from "../../../components/Scroll/GoToTop";
import { TitleFunction } from "../../../utils/TitleFunction";
import Banner from "../components/Banner";
import Cinema from "../components/Cinema";
import Showing from "../components/Showing";

export default function Home() {
  TitleFunction("Movie");

  return (
    <div>
      <Banner />
      <Showing />
      <Cinema />

      <GoToTop />
    </div>
  );
}
