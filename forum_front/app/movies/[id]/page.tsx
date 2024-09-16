export default async function MovieDetail({
  params: { id },
}: {
  params: { id: string };
}) {
  return (
    <div>
      <h2>{`You are watching ${id}`}</h2>
    </div>
  );
}
