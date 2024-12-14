"use client";

import React, { useEffect, useState } from "react";
import { useParams } from "next/navigation";
import ForumDetail from "@/components/forum/ForumDetail";
import CommentList from "@/components/forum/CommentList";
import CommentForm from "@/components/forum/CommentForm";

export default function ForumDetailPage() {
  const backendHost = process.env.NEXT_PUBLIC_BACKEND_HOST;

  const { forumId } = useParams();
  const [forum, setForum] = useState<Forum>();
  const [comments, setComments] = useState([]);

  useEffect(() => {
    fetch(`${backendHost}/public/forums/${forumId}`)
      .then((response) => response.json())
      .then((data) => setForum(data))
      .catch((error) => console.error("Error fetching forum:", error));

    fetch(`${backendHost}/public/comments/forum/${forumId}`)
      .then((response) => response.json())
      .then((data) => setComments(data))
      .catch((error) => console.error("Error fetching comments:", error));
  }, [forumId]);

  return (
    <div className="container mx-auto p-6">
      {forum && <ForumDetail forum={forum} />}
      <h2 className="text-xl font-bold mt-6">Comments</h2>
      <CommentList comments={comments} />
      <CommentForm forumId={forumId} setComments={setComments} />
    </div>
  );
}
