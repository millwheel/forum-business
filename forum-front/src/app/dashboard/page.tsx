"use client";

import { useEffect } from "react";
import { useRouter } from "next/navigation";

export default function DashboardPage() {
  const router = useRouter();

  useEffect(() => {
    const token = document.cookie.includes("access_token");
    if (!token) {
      router.push("/login");
    }
  }, []);

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-6">Dashboard</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        <div className="bg-white p-4 rounded shadow">
          <h2 className="text-xl font-bold">Welcome</h2>
          <p>This is your dashboard.</p>
        </div>
        <div className="bg-white p-4 rounded shadow">
          <h2 className="text-xl font-bold">Profile</h2>
          <p>Manage your profile settings here.</p>
        </div>
        <div className="bg-white p-4 rounded shadow">
          <h2 className="text-xl font-bold">Activity</h2>
          <p>View recent activity in your account.</p>
        </div>
      </div>
    </div>
  );
}
