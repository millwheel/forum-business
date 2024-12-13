"use client";

import React, { useEffect, useState } from "react";
import AuthButtons from "./AuthButtons";

export default function AuthManager() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = document.cookie.includes("access_token");
    setIsAuthenticated(token);
  }, []);

  return <AuthButtons isAuthenticated={isAuthenticated} />;
}
