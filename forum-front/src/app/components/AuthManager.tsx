"use client";

import React, { useEffect, useState } from "react";
import AuthButtons from "./AuthButtons";

export default function AuthManager() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [shouldRender, setShouldRender] = useState(true);

  useEffect(() => {
    if (typeof window !== "undefined") {
      const currentPath = window.location.pathname;

      if (currentPath === "/login") {
        setShouldRender(false);
        return;
      }

      const tokenExists = document.cookie.includes("access_token");
      setIsAuthenticated(tokenExists);
    }
  }, []);

  if (!shouldRender) {
    return null;
  }

  return <AuthButtons isAuthenticated={isAuthenticated} />;
}
