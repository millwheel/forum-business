"use client";

import React from "react";

export default function ForumDetail({ forum }: { forum: any }) {
  return (
    <div className="border p-4 rounded shadow max-w-[800px] mx-auto">
      <h1 className="text-2xl font-bold">{forum.title}</h1>
      <p>{forum.description}</p>
      <p className="text-sm text-gray-500">Author: {forum.author}</p>
    </div>
  );
}
