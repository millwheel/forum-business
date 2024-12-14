"use client";

import React, { useState } from "react";

export default function CommentForm({ forumId, setComments }: any) {
  const [description, setDescription] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();

    fetch(`http://localhost:8081/comments/forum/${forumId}`, {
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
        setDescription(""); // 입력 필드 초기화
      })
      .catch((error) => console.error("Error creating comment:", error));
  };

  return (
    <form onSubmit={handleSubmit} className="mt-4">
      <textarea
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        placeholder="Write a comment..."
        className="w-full border p-2 rounded"
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
