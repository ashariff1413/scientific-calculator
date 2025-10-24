# Git Setup Guide - Fix Lock Error

## 🔧 Fix "Another git process seems to be running" Error

This error happens when Git gets interrupted. Here's how to fix it:

---

## Quick Fix

### Option 1: Delete Lock File (If .git exists)
```bash
# In PowerShell or CMD
del .git\index.lock
```

### Option 2: Start Fresh (Recommended)
Just delete the `.git` folder and start over:
```bash
# In PowerShell
Remove-Item -Recurse -Force .git

# Then initialize again
git init
```

---

## 🚀 Step-by-Step Git Setup (From Scratch)

### Step 1: Open Terminal in Clean Folder
1. Open `Scientific-Calculator-Clean` folder
2. Right-click in empty space
3. Select "Open in Terminal" or "Git Bash Here"

### Step 2: Initialize Git
```bash
git init
```

### Step 3: Add Files
```bash
git add .
```

### Step 4: Commit
```bash
git commit -m "Initial commit - Scientific Calculator v1.0"
```

### Step 5: Create GitHub Repository
1. Go to https://github.com
2. Click "New repository"
3. Name: `scientific-calculator`
4. Description: "Advanced scientific calculator with calculus"
5. Keep it Public (or Private if you prefer)
6. DON'T initialize with README (you already have one)
7. Click "Create repository"

### Step 6: Connect to GitHub
```bash
# Replace 'yourusername' with your GitHub username
git remote add origin https://github.com/yourusername/scientific-calculator.git
git branch -M main
git push -u origin main
```

---

## 🆘 Troubleshooting

### Error: "Another git process seems to be running"
**Solution:**
```bash
# Delete the lock file
del .git\index.lock

# Or start fresh
Remove-Item -Recurse -Force .git
git init
```

### Error: "fatal: not a git repository"
**Solution:**
```bash
# You're not in the right folder
cd Scientific-Calculator-Clean
git init
```

### Error: "Permission denied"
**Solution:**
```bash
# Run as administrator
# Or close any programs that might be using the folder
```

### Error: "remote origin already exists"
**Solution:**
```bash
# Remove old remote
git remote remove origin

# Add new remote
git remote add origin https://github.com/yourusername/scientific-calculator.git
```

---

## 📋 Complete Fresh Start (If Everything Fails)

```bash
# 1. Delete .git folder if it exists
Remove-Item -Recurse -Force .git -ErrorAction SilentlyContinue

# 2. Initialize Git
git init

# 3. Configure Git (first time only)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# 4. Add all files
git add .

# 5. Commit
git commit -m "Initial commit"

# 6. Add remote (replace with your GitHub URL)
git remote add origin https://github.com/yourusername/scientific-calculator.git

# 7. Push
git branch -M main
git push -u origin main
```

---

## ✅ Verify It Worked

After pushing, check:
1. Go to your GitHub repository URL
2. You should see all your files
3. 29 files should be visible
4. README.md should display on the main page

---

## 🎯 Alternative: Use GitHub Desktop (Easier!)

If command line is confusing:

1. **Download GitHub Desktop:** https://desktop.github.com/
2. **Install and sign in**
3. **Add repository:**
   - File → Add Local Repository
   - Choose `Scientific-Calculator-Clean` folder
   - Click "Create Repository"
4. **Publish:**
   - Click "Publish repository"
   - Choose name and description
   - Click "Publish"

**Done!** Much easier with GUI!

---

## 📝 Git Commands Cheat Sheet

```bash
# Initialize
git init

# Check status
git status

# Add files
git add .
git add filename.txt

# Commit
git commit -m "Your message"

# Push to GitHub
git push

# Pull from GitHub
git pull

# Check remote
git remote -v

# View history
git log
```

---

## 🎓 What Each Command Does

- `git init` - Creates .git folder, starts tracking
- `git add .` - Stages all files for commit
- `git commit` - Saves a snapshot of your code
- `git remote add origin` - Links to GitHub
- `git push` - Uploads to GitHub
- `git pull` - Downloads from GitHub

---

## 💡 Tips

1. **Always commit before closing** - Don't leave Git in middle of operation
2. **Use meaningful commit messages** - "Fixed bug" not "asdf"
3. **Commit often** - Small commits are better than big ones
4. **Don't commit large files** - Use .gitignore (already included!)
5. **Pull before push** - Get latest changes first

---

## 🎉 Once It's on GitHub

Your repository will be at:
```
https://github.com/yourusername/scientific-calculator
```

You can:
- ✅ Share the link
- ✅ Show it on your resume
- ✅ Let others contribute
- ✅ Track changes over time
- ✅ Never lose your code

---

**Need help? The error is usually just a lock file. Delete it and try again!**
