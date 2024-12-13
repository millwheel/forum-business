"use client";

import React from "react";

export default function ForumDetail({ forum }: { forum: any }) {
  const truncatedDescription =
    forum.description.length > 30
      ? forum.description.slice(0, 30) + "..."
      : forum.description;
  return (
    <div className="border p-4 rounded shadow">
      <h1 className="text-2xl font-bold">{forum.title}</h1>
      <p>{truncatedDescription}</p>
      <p className="text-sm text-gray-500">Author: {forum.author}</p>
    </div>
  );
}
