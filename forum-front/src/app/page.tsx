"use client";

import { useRouter } from "next/navigation";
import { useEffect } from "react";

export default function HomePage() {
  const router = useRouter();

  useEffect(() => {
    const token = document.cookie.includes("access_token");
    if (token) {
      router.push("/forums");
    }
  }, []);

  return (
    <div>
      <h1>Welcome to Forum</h1>
    </div>
  );
}
