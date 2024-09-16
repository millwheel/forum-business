import { createClient } from '@supabase/supabase-js'

const supabaseUrl = 'https://rotpmxrslspmgtjspvma.supabase.co'
const supabaseAnonKey = process.env.SUBABASE_ANON_KEY as string;

if (!process.env.SUBABASE_ANON_KEY) {
    throw new Error('Missing environment variable: SUBABASE_ANON_KEY');
}

export const supabase = createClient(supabaseUrl, supabaseAnonKey)
