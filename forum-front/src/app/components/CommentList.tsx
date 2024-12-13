"use client";

import React from "react";

export default function CommentList({ comments }: { comments: any[] }) {
  return (
    <ul className="space-y-4">
      {comments.map((comment) => (
        <li key={comment.id} className="border p-4 rounded shadow">
          <p>{comment.description}</p>
          <p className="text-sm text-gray-500">Author: {comment.author}</p>
        </li>
      ))}
    </ul>
  );
}
