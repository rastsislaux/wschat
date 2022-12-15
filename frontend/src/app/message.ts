export interface Message {
  id: string | undefined;
  type: "CHAT" | "JOIN" | "LEAVE";
  content: string | undefined;
  sender: string | undefined;
}

export interface AuthInfo {
  isUnlogged: boolean;
  sender: string;
}
