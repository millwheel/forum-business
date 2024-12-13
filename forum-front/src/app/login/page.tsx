"use client";

export default function LoginPage() {
  const handleLogin = () => {
    const keycloakUrl = process.env.NEXT_PUBLIC_KEYCLOAK_URL;
    const realm = process.env.NEXT_PUBLIC_KEYCLOAK_REALM;
    const clientId = process.env.NEXT_PUBLIC_KEYCLOAK_CLIENT_ID;
    const redirectUri = encodeURIComponent(
      process.env.NEXT_PUBLIC_KEYCLOAK_REDIRECT_URI!,
    );

    const loginUrl = `${keycloakUrl}/realms/${realm}/protocol/openid-connect/auth?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}`;
    window.location.href = loginUrl;
  };

  return (
    <div>
      <button onClick={handleLogin}>Login with Keycloak</button>
    </div>
  );
}
