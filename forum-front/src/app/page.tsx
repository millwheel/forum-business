"use client";

import { useRouter } from "next/navigation";
import React, { useEffect } from "react";

export default function HomePage() {
  const router = useRouter();

  useEffect(() => {
    const token = document.cookie.includes("access_token");
    if (token) {
      router.push("/dashboard");
    }
  }, []);

  return (
    <div className="flex items-center justify-center h-72">
      <div className="text-center">
        <h1 className="text-2xl font-bold">Welcome to Forum</h1>
      </div>
    </div>
  );
}
