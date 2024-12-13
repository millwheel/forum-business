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
    <div>
      {isAuthenticated ? (
        <button onClick={handleLogout}>Logout</button>
      ) : (
        <button onClick={() => (window.location.href = "/login")}>Login</button>
      )}
    </div>
  );
}
