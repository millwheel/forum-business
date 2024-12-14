"use client";

import React, { useEffect, useState } from "react";
import ForumList from "@/components/forum/ForumList";

export default function ForumPage() {
  const [forums, setForums] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/public/forums")
      .then((response) => response.json())
      .then((data) => setForums(data))
      .catch((error) => console.error("Error fetching forums:", error));
  }, []);

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-4xl font-bold mb-4">Forum List</h1>
      <ForumList forums={forums} />
    </div>
  );
}
