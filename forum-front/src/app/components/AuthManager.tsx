"use client";

import React, { useEffect, useState } from "react";
import AuthButtons from "./AuthButtons";

export default function AuthManager() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    // 쿠키 또는 토큰을 확인하여 인증 상태를 설정
    const token = document.cookie.includes("access_token");
    setIsAuthenticated(token);
  }, []);

  return <AuthButtons isAuthenticated={isAuthenticated} />;
}
