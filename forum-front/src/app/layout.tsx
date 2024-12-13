import type { Metadata } from "next";
import "./globals.css";
import React from "react";
import AuthManager from "@/app/components/AuthManager";

export const metadata: Metadata = {
  title: "Forum App",
  description: "Generated by create next app",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className="bg-gray-100 flex flex-col min-h-screen max-h-screen">
        {/* Header */}
        <header className="bg-gray-800 text-white p-4 shadow-md">
          <div className="container mx-auto flex justify-between items-center">
            <h1 className="text-2xl font-bold">Forum App</h1>
          </div>
          <AuthManager />
        </header>

        {/* Main Content */}
        <div className="container mx-auto text-center flex-grow overflow-auto">
          {children}
        </div>

        {/* Footer */}
        <footer className="bg-gray-800 text-white text-center py-4">
          © 2024 Forum App. All Rights Reserved.
        </footer>
      </body>
    </html>
  );
}
