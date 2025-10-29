# Web Application Project

Welcome to our modern web application! This guide will help you get started with running and developing the project, especially if you're new to web development.

## Tech Stack

- **[SvelteKit](https://kit.svelte.dev/)** - A powerful framework for building web applications
- **[Vite](https://vitejs.dev/)** - Next Generation Frontend Tooling
- **[pnpm](https://pnpm.io/)** - Fast, disk space efficient package manager
- **Node.js** - JavaScript runtime environment

## Getting Started (For Beginners)

### Step 1: Install Required Software

1. **Install Node.js**
   - Go to [Node.js website](https://nodejs.org/)
   - Download and install the "LTS" (Long Term Support) version
   - To check if it's installed, open Command Prompt (or PowerShell) and type:
     ```bash
     node --version
     ```

2. **Install pnpm**
   - After Node.js is installed, open Command Prompt (or PowerShell) and run:
     ```bash
     npm install -g pnpm
     ```
   - Verify it worked by running:
     ```bash
     pnpm --version
     ```

### Step 2: Run the Project

1. **Install Project Dependencies**
   - Open Command Prompt (or PowerShell)
   - Navigate to the project folder
   - Run:
     ```bash
     pnpm install
     ```

2. **Start the Development Server**
   - In the same terminal, run:
     ```bash
     pnpm run dev
     ```
   - Wait until you see a message saying the server is ready
   - Open your web browser and go to: `http://localhost:5173`

That's it! You should now see the website running on your computer. 🎉

## Project Structure Explained

```
src/
├── lib/              # Reusable components and code
├── routes/           # Your website pages live here
│   ├── +layout.svelte    # Main layout (appears on every page)
│   └── +page.svelte      # Home page
└── app.html         # Main HTML template
```

## Common Tasks

### Making Changes
- Edit files in the `src/routes` folder to change pages
- Your changes will appear automatically in the browser
- If something breaks, just restart the dev server (Ctrl+C, then `pnpm run dev`)

### Building for Production
```bash
pnpm run build
```

### Preview Production Build
```bash
pnpm run preview
```

## Need Help?

- Check out [Svelte's beginner tutorial](https://svelte.dev/tutorial)
- Visit [SvelteKit documentation](https://kit.svelte.dev/docs)
- Join the [Svelte Discord community](https://svelte.dev/chat)

## Troubleshooting

If you run into problems:

1. Make sure Node.js is installed correctly
2. Try running `pnpm install` again
3. Clear your browser cache
4. Make sure no other programs are using port 5173
