# Quick Reference Guide

## 📁 Where is Everything?

### 🎯 I want to...

#### Share with friends
→ `dist/ScientificCalculator-1.0.exe` (190 MB installer)

#### Run the calculator now
→ `dist/ScientificCalculator/ScientificCalculator.exe` (portable)
→ OR run `scripts/run-calculator.bat`

#### Edit the code
→ `src/` folder (all .java files)

#### Rebuild the project
→ Run `scripts/build-jar.bat`

#### Read user instructions
→ `docs/README-FOR-USERS.md`

#### Learn how to share
→ `docs/SHARE-WITH-FRIENDS.md`

#### See all distribution options
→ `docs/DISTRIBUTION-SUMMARY.md`

#### Understand project structure
→ `PROJECT-STRUCTURE.md`

---

## 📂 Folder Quick Guide

| Folder | Contains | Purpose |
|--------|----------|---------|
| **src/** | *.java files | Source code |
| **dist/** | .exe, .jar files | Ready to share |
| **docs/** | *.md files | Documentation |
| **scripts/** | *.bat files | Build scripts |
| **build-output/** | *.class files | Compiled code |
| **bin/** | JDK tools | Java compiler/runtime |

---

## 🚀 Common Tasks

### Run Calculator
```bash
# Option 1: Run portable version
dist\ScientificCalculator\ScientificCalculator.exe

# Option 2: Run from JAR
scripts\run-calculator.bat

# Option 3: Install and run
dist\ScientificCalculator-1.0.exe
```

### Rebuild Project
```bash
# Build JAR
scripts\build-jar.bat

# Build installer (needs WiX)
scripts\create-installer.bat
```

### Share with Friends
1. Upload `dist/ScientificCalculator-1.0.exe` to Google Drive
2. Share the link
3. Done!

See `docs/SHARE-WITH-FRIENDS.md` for details.

---

## 📄 Important Files

| File | Location | Description |
|------|----------|-------------|
| **Main Installer** | `dist/ScientificCalculator-1.0.exe` | Share this! |
| **Portable EXE** | `dist/ScientificCalculator/ScientificCalculator.exe` | No install needed |
| **JAR File** | `dist/ScientificCalculator.jar` | Cross-platform |
| **Main Code** | `src/Calculator.java` | GUI application |
| **User Guide** | `docs/README-FOR-USERS.md` | For end users |
| **This README** | `README.md` | Project overview |

---

## 🎓 Documentation Index

| Document | Purpose | Audience |
|----------|---------|----------|
| `README.md` | Project overview | Everyone |
| `PROJECT-STRUCTURE.md` | Folder organization | Developers |
| `QUICK-REFERENCE.md` | Quick guide (this file) | Everyone |
| `docs/README-FOR-USERS.md` | How to use calculator | End users |
| `docs/SHARE-WITH-FRIENDS.md` | How to share | You |
| `docs/DISTRIBUTION-SUMMARY.md` | All distribution options | You |
| `docs/INSTALLER-READY.md` | Installer details | You |
| `docs/QUICK-START.md` | Quick start | End users |

---

## 💡 Tips

### For Development:
- Edit files in `src/`
- Run `scripts/build-jar.bat` to compile
- Test changes immediately

### For Distribution:
- Main file: `dist/ScientificCalculator-1.0.exe`
- Upload to Google Drive or GitHub
- Share the link

### For Users:
- Give them `docs/README-FOR-USERS.md`
- Or just the installer link
- They don't need Java!

---

## ✅ Checklist

### Before Sharing:
- [ ] Test `dist/ScientificCalculator-1.0.exe`
- [ ] Verify all features work
- [ ] Read `docs/SHARE-WITH-FRIENDS.md`
- [ ] Upload to Google Drive/GitHub
- [ ] Get shareable link
- [ ] Send to friends!

### Before Modifying Code:
- [ ] Backup current version
- [ ] Edit files in `src/`
- [ ] Run `scripts/build-jar.bat`
- [ ] Test changes
- [ ] Rebuild installer if needed

---

## 🆘 Troubleshooting

**Can't find the installer:**
→ Look in `dist/ScientificCalculator-1.0.exe`

**Want to rebuild:**
→ Run `scripts/build-jar.bat`

**Need to share:**
→ Read `docs/SHARE-WITH-FRIENDS.md`

**Code not working:**
→ Check `src/` for source files
→ Recompile with `scripts/build-jar.bat`

**Documentation unclear:**
→ Check `docs/` folder for specific guides

---

## 🎯 Most Important Files

1. **`dist/ScientificCalculator-1.0.exe`** - Share this with friends!
2. **`docs/SHARE-WITH-FRIENDS.md`** - How to share
3. **`README.md`** - Project overview
4. **`src/Calculator.java`** - Main source code

---

**Everything is organized and ready to use!** 🎉
