"use client";

import React, { useEffect, useState } from "react";
import AuthButtons from "./AuthButtons";
import { useAuth } from "@/components/auth/AuthContext";

export default function AuthButtonManager() {
  const { accessToken } = useAuth();

  const currentPath =
    typeof window !== "undefined" ? window.location.pathname : "";

  if (currentPath === "/auth/login") {
    return null;
  }

  const isAuthenticated = Boolean(accessToken);

  return <AuthButtons isAuthenticated={isAuthenticated} />;
}
