"use client";

import React from "react";
import Link from "next/link";

export default function ForumList({ forums }: { forums: any[] }) {
  return (
    <ul className="space-y-4 max-w-[800px] mx-auto">
      {forums.map((forum) => (
        <li
          key={forum.id}
          className="border p-4 rounded shadow flex justify-between items-center"
        >
          <Link
            href={`/forums/${forum.id}`}
            className="text-lg font-bold text-blue-500 hover:underline"
          >
            {forum.title}
          </Link>
          <p className="text-sm text-gray-500">Author: {forum.author}</p>
        </li>
      ))}
    </ul>
  );
}
