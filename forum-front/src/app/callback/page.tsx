"use client";

import { useEffect } from "react";
import { useRouter } from "next/navigation";

export default function CallbackPage() {
  const router = useRouter();

  useEffect(() => {
    const urlParams = new URLSearchParams(window.location.search);
    const code = urlParams.get("code");

    if (code) {
      fetch("/api/auth/callback?code=" + code).then((response) => {
        if (response.ok) {
          router.push("/dashboard");
        } else {
          console.error("Failed to authenticate");
        }
      });
    }
  }, []);

  return <div>Authenticating...</div>;
}
