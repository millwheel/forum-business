"use client";

import { useEffect } from "react";
import { useRouter } from "next/navigation";
import { useAuth } from "@/components/auth/AuthContext";

export default function CallbackPage() {
  const router = useRouter();
  const { setAccessToken } = useAuth();

  useEffect(() => {
    const keycloakHost = process.env.NEXT_PUBLIC_KEYCLOAK_HOST!;
    const realm = process.env.NEXT_PUBLIC_KEYCLOAK_REALM!;
    const clientId = process.env.NEXT_PUBLIC_KEYCLOAK_CLIENT_ID!;
    const redirectUri = process.env.NEXT_PUBLIC_KEYCLOAK_REDIRECT_URI!;
    const urlParams = new URLSearchParams(window.location.search);
    const code = urlParams.get("code");

    if (code) {
      fetch(`${keycloakHost}/realms/${realm}/protocol/openid-connect/token`, {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams({
          grant_type: "authorization_code",
          client_id: clientId,
          redirect_uri: redirectUri,
          code: code,
        }).toString(),
      })
        .then((response) => response.json())
        .then((data) => {
          if (data.access_token) {
            console.log("Access Token:", data.access_token);
            setAccessToken(data.access_token);
            router.push("/forums");
          } else {
            console.error("Failed to authenticate:", data.error);
          }
        })
        .catch((error) => {
          console.error("Error during authentication:", error);
        });
    }
  }, [router]);

  return <div>Authenticating...</div>;
}
