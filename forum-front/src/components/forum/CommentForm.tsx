"use client";

import React, { useState } from "react";

export default function CommentForm({ forumId, setComments }: any) {
  const backendHost = process.env.NEXT_PUBLIC_BACKEND_HOST;

  const [description, setDescription] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();

    fetch(`${backendHost}/comments/forum/${forumId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        description,
        author: "test user",
      }),
    })
      .then((response) => response.json())
      .then((newComment) => {
        setComments((prevComments: any[]) => [...prevComments, newComment]);
        setDescription("");
      })
      .catch((error) => console.error("Error creating comment:", error));
  };

  return (
    <form onSubmit={handleSubmit} className="mt-4 max-w-[800px] mx-auto">
      <textarea
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        placeholder="Write a comment..."
        className="w-full border p-2 h-28 rounded resize-none"
      />
      <button
        type="submit"
        className="mt-2 bg-blue-600 text-white py-2 px-4 rounded hover:bg-blue-700"
      >
        Submit Comment
      </button>
    </form>
  );
}
