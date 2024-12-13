"use client";

export default function AuthButtons({
  isAuthenticated,
}: {
  isAuthenticated: boolean;
}) {
  const handleLogout = () => {
    document.cookie = "access_token=; Max-Age=0; Path=/";
    window.location.href = "/";
  };

  return (
    <div className="absolute top-4 right-4">
      {isAuthenticated ? (
        <button
          onClick={handleLogout}
          className="bg-gray-700 text-white px-6 py-2 rounded hover:bg-red-600"
        >
          Logout
        </button>
      ) : (
        <button
          onClick={() => (window.location.href = "/login")}
          className="bg-gray-700 text-white px-6 py-2 rounded hover:bg-red-600"
        >
          Login
        </button>
      )}
    </div>
  );
}
