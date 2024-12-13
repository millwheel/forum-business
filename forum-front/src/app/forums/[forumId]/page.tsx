"use client";

import React, { useEffect, useState } from "react";
import { useParams } from "next/navigation";
import ForumDetail from "@/app/components/ForumDetail";
import CommentList from "@/app/components/CommentList";
import CommentForm from "@/app/components/CommentForm";

export default function ForumDetailPage() {
  const { forumId } = useParams();
  const [forum, setForum] = useState(null);
  const [comments, setComments] = useState([]);

  useEffect(() => {
    // 게시판 정보 가져오기
    fetch(`http://localhost:8081/public/forums/${forumId}`)
      .then((response) => response.json())
      .then((data) => setForum(data))
      .catch((error) => console.error("Error fetching forum:", error));

    // 댓글 가져오기
    fetch(`http://localhost:8081/public/comments/forum/${forumId}`)
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
