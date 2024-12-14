"use client";

import { useEffect } from "react";
import { useRouter } from "next/navigation";

export default function CallbackPage() {
  const router = useRouter();

  useEffect(() => {
    const keycloakUrl = process.env.NEXT_PUBLIC_KEYCLOAK_URL!;
    const realm = process.env.NEXT_PUBLIC_KEYCLOAK_REALM!;
    const clientId = process.env.NEXT_PUBLIC_KEYCLOAK_CLIENT_ID!;
    const redirectUri = process.env.NEXT_PUBLIC_KEYCLOAK_REDIRECT_URI!;
    const urlParams = new URLSearchParams(window.location.search);
    const code = urlParams.get("code");

    if (code) {
      fetch(`${keycloakUrl}/realms/${realm}/protocol/openid-connect/token`, {
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
            document.cookie = `access_token=${data.access_token}; path=/; max-age=${data.expires_in}`;
            router.push("/dashboard");
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
