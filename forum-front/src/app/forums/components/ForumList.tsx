"use client";

import React from "react";
import Link from "next/link";

export default function ForumList({ forums }: { forums: any[] }) {
  return (
    <ul className="space-y-4">
      {forums.map((forum) => (
        <li key={forum.id} className="border p-4 rounded shadow">
          <h2 className="text-lg font-bold">{forum.title}</h2>
          <p>{forum.description}</p>
          <p className="text-sm text-gray-500">Author: {forum.author}</p>
          <Link
            href={`/forums/${forum.id}`}
            className="text-blue-500 underline"
          >
            View Details
          </Link>
        </li>
      ))}
    </ul>
  );
}
