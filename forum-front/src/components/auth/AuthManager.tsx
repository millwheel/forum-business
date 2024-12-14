"use client";

import React, { useEffect, useState } from "react";
import AuthButtons from "./AuthButtons";

export default function AuthManager() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    if (typeof window !== "undefined") {
      const tokenExists = document.cookie.includes("access_token");
      setIsAuthenticated(tokenExists);
    }
  }, []);

  const currentPath =
    typeof window !== "undefined" ? window.location.pathname : "";

  if (currentPath === "/auth/login") {
    return null;
  }

  return <AuthButtons isAuthenticated={isAuthenticated} />;
}
