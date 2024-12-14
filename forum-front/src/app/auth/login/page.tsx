"use client";

export default function LoginPage() {
  const keycloakHost = process.env.NEXT_PUBLIC_KEYCLOAK_HOST;
  const realm = process.env.NEXT_PUBLIC_KEYCLOAK_REALM;
  const clientId = process.env.NEXT_PUBLIC_KEYCLOAK_CLIENT_ID;
  const redirectUri = encodeURIComponent(
    process.env.NEXT_PUBLIC_KEYCLOAK_REDIRECT_URI!,
  );

  const handleLogin = () => {
    const loginUrl = `${keycloakHost}/realms/${realm}/protocol/openid-connect/auth?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}`;
    window.location.href = loginUrl;
  };

  const handleRegister = () => {
    const registerUrl = `${keycloakHost}/realms/${realm}/protocol/openid-connect/registrations?client_id=${clientId}&response_type=code&redirect_uri=${redirectUri}`;
    window.location.href = registerUrl;
  };

  return (
    <div className="flex flex-col items-center justify-center h-96 bg-gray-100">
      {/* Welcome Text */}
      <div className="text-center mb-8">
        <h1 className="text-4xl font-bold text-gray-800 mb-4">Login Page</h1>
        <p className="text-lg text-gray-600">Choose what you want to proceed</p>
      </div>

      {/* Login Button */}
      <div className="flex space-x-4">
        <button
          onClick={handleLogin}
          className="bg-blue-600 text-white font-bold py-3 px-6 rounded-lg shadow-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-all"
        >
          Login
        </button>
        <button
          onClick={handleRegister}
          className="bg-gray-600 text-white font-bold py-3 px-6 rounded-lg shadow-lg hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2 transition-all"
        >
          Register
        </button>
      </div>
    </div>
  );
}
