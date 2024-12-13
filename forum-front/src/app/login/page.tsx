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
    <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
      {/* Welcome Text */}
      <div className="text-center mb-8">
        <h1 className="text-4xl font-bold text-gray-800 mb-4">
          Welcome to Our Platform
        </h1>
        <p className="text-lg text-gray-600">
          Please log in to access your personalized dashboard.
        </p>
      </div>

      {/* Login Button */}
      <button
        onClick={handleLogin}
        className="bg-blue-600 text-white font-bold py-3 px-6 rounded-lg shadow-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-all"
      >
        Login with Keycloak
      </button>
    </div>
  );
}
