import { login, signup } from "./actions";

export default function LoginPage() {
  return (
    <form>
      <div className="m-2">
        <label htmlFor="email">Email:</label>
        <input
          className="border-2"
          id="email"
          name="email"
          type="email"
          required
        />
      </div>
      <div className="m-2">
        <label htmlFor="password">Password:</label>
        <input
          className="border-2"
          id="password"
          name="password"
          type="password"
          required
        />
      </div>
      <div className="m-2">
        <button
          className="h-10 px-6 rounded-md bg-black text-white"
          formAction={login}
        >
          Log in
        </button>
      </div>
      <div className="m-2">
        <button
          className="h-10 px-6 rounded-md bg-black text-white"
          formAction={signup}
        >
          Sign up
        </button>
      </div>
    </form>
  );
}
