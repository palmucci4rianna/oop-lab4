# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory
mkdir deleteme

### Si inizializzi un repository Git dentro la cartella suddetta.
cd deleteme
git init
Inizializzato repository Git vuoto in /Users/ariannapalmucci/Desktop/deleteme/.git/

### Si osservi lo stato del repository
git status

Sul branch main
Non ci sono ancora commit
non c'è nulla di cui eseguire il commit (crea/copia dei file e usa "git add" per tracciarli)

### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
touch HelloWorld.java
nano HelloWorld

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
git status
Sul branch main

Non ci sono ancora commit
Modifiche di cui verrà eseguito il commit:
  (usa "git rm --cached <file>..." per rimuovere gli elementi dall'area di staging)
	nuovo file:             HelloWorld.java

### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "aggiunto e aggiornato file HelloWorld.java"
[main (commit radice) 00e2d56] aggiunto e aggiornato file HelloWorld.java
 1 file changed, 5 insertions(+)
 create mode 100644 HelloWorld.java

### Si compili il file Java e si verifichi lo stato del repository
javac -d . HelloWorld.java
git status
Sul branch main
File non tracciati:
  (usa "git add <file>..." per includere l'elemento fra quelli di cui verrà eseguito il commit)
	HelloWorld.class

non è stato aggiunto nulla al commit ma sono presenti file non tracciati (usa "git add" per tracciarli)

### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
touch .gitignore
nano .gitignore
cat .gitignore 
*.class

### Si osservi lo stato del repository
❯ git add .gitignore
❯ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore

❯ git commit -m 'create an ignore list'
[master ad267b4] create an ignore list
 1 file changed, 1 insertion(+)
 create mode 100644 .gitignore
❯ git status
On branch master
nothing to commit, working tree clean

### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git commit -m "aggiunto gitignore per file .class"
[main 7c2feb5] aggiunto gitignore per file .class
 1 file changed, 1 insertion(+)
 create mode 100644 .gitignore
git status
Sul branch main
non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
touch .gitattributes 
nano .gitattributes
cat .gitattributes
* text=auto eol=lf
*.[cC][mM][dD] text eol=crlf
*.[bB][aA][tT] text eol=crlf
*.[pP][sS]1 text eol=crlf

### Si osservi la storia del repository usando `git log --all --graph`
* commit 6220c38ad573111663b0e5480797ed7d9bce2a1d (HEAD -> main)
| Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
| Date:   Sun Oct 19 18:26:25 2025 +0200
| 
|     aggiunto gitattributes per caratteri fine linea
| 
* commit 7c2feb503adc1413811cb5b00133353521468d63
| Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
| Date:   Sun Oct 19 18:21:23 2025 +0200
| 
|     aggiunto gitignore per file .class
| 
* commit 00e2d56c3d612d90f8a5287f14910543cecbf28d
  Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
  Date:   Sun Oct 19 18:15:57 2025 +0200
  
      aggiunto e aggiornato file HelloWorld.java

### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`
Sul branch main
non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
touch Mistake.java
nano Mistake.java
cat Mistake.java
mille_errori
git status
Sul branch main
File non tracciati:
  (usa "git add <file>..." per includere l'elemento fra quelli di cui verrà eseguito il commit)
	Mistake.java

non è stato aggiunto nulla al commit ma sono presenti file non tracciati (usa "git add" per tracciarli)
git add Mistake.java
git commit -m "aggiunto file Mistake.java"
[main 6af9bfe] aggiunto file Mistake.java
 1 file changed, 1 insertion(+)
 create mode 100644 Mistake.java
git status
Sul branch main
non c'è nulla di cui eseguire il commit, l'albero di lavoro è pulito

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica
mv Mistake.java ToDelete.java
git status
Sul branch main
Modifiche non nell'area di staging per il commit:
  (usa "git add/rm <file>..." per aggiornare gli elementi di cui sarà eseguito il commit)
  (usa "git restore <file>..." per scartare le modifiche nella directory di lavoro)
	eliminato:              Mistake.java

File non tracciati:
  (usa "git add <file>..." per includere l'elemento fra quelli di cui verrà eseguito il commit)
	ToDelete.java

nessuna modifica aggiunta al commit (usa "git add" e/o "git commit -a")
git add ToDelete.java Mistake.java
git commit -m "rinominato Mistake.java in ToDelete.java"
[main 2302349] rinominato Mistake.java in ToDelete.java
 1 file changed, 0 insertions(+), 0 deletions(-)
 rename Mistake.java => ToDelete.java (100%)

### Si elimini `ToDelete.java` e si registri la modifica in un commit
rm ToDelete.java
git status
On branch master
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    ToDelete.java

no changes added to commit (use "git add" and/or "git commit -a")
git add ToDelete.java
git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        deleted:    ToDelete.java

git commit -m 'rimosso ToDeleTe.java'
[main 3471e9a] rimosso ToDelete.java
 1 file changed, 1 deletion(-)
 delete mode 100644 ToDelete.java

### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`
git log
commit 3471e9a8262c2789cac63731fc2760f3f990318a (HEAD -> main)
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:31:54 2025 +0200

    rimosso ToDelete.java

commit 23023498d4caee03b8009957ee33bd2ece691df8
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:29:41 2025 +0200

    rinominato Mistake.java in ToDelete.java

commit 6af9bfead81eb7a15d41385bb16c24281ae90bd5
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:28:25 2025 +0200

    aggiunto file Mistake.java

commit 6220c38ad573111663b0e5480797ed7d9bce2a1d
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:26:25 2025 +0200

    aggiunto gitattributes per caratteri fine linea

commit 7c2feb503adc1413811cb5b00133353521468d63
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:21:23 2025 +0200

    aggiunto gitignore per file .class

commit 00e2d56c3d612d90f8a5287f14910543cecbf28d
Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
Date:   Sun Oct 19 18:15:57 2025 +0200

    aggiunto e aggiornato file HelloWorld.java

git log --all --graph --oneline
* 3471e9a (HEAD -> main) rimosso ToDelete.java
* 2302349 rinominato Mistake.java in ToDelete.java
* 6af9bfe aggiunto file Mistake.java
* 6220c38 aggiunto gitattributes per caratteri fine linea
* 7c2feb5 aggiunto gitignore per file .class
* 00e2d56 aggiunto e aggiornato file HelloWorld.java

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout 6af9bfe -- Mistake.java
git status
Sul branch main
Modifiche di cui verrà eseguito il commit:
  (usa "git restore --staged <file>..." per rimuovere gli elementi dall'area di staging)
	nuovo file:             Mistake.java

### Si rimuova il file ripristinato e si ripulisca lo stage
❯ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   Mistake.java

❯ git reset Mistake.java
❯ git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        Mistake.java

nothing added to commit but untracked files present (use "git add" to track)
❯ rm Mistake.java
❯ git status
On branch master
nothing to commit, working tree clean

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git checkout 6220c3  
Nota: eseguo il checkout di '6220c3'.

Sei nello stato 'HEAD scollegato'. Puoi dare un'occhiata, apportare modifiche
sperimentali ed eseguirne il commit, e puoi scartare qualunque commit eseguito
in questo stato senza che ciò abbia alcuna influenza sugli altri branch tornando
su un branch.

Se vuoi creare un nuovo branch per mantenere i commit creati, puoi farlo
(ora o in seguito) usando l'opzione -c con il comando switch. Ad esempio:

  git switch -c <nome nuovo branch>

Oppure puoi annullare quest'operazione con:

  git switch -

Disattiva questo consiglio impostando la variabile di configurazione
advice.detachedHead a false

HEAD si trova ora a 6220c38 aggiunto gitattributes per caratteri fine linea
ariannapalmucci@Mac deleteme % git log --all --graph --oneline
* 3471e9a (main) rimosso ToDelete.java
* 2302349 rinominato Mistake.java in ToDelete.java
* 6af9bfe aggiunto file Mistake.java
* 6220c38 (HEAD) aggiunto gitattributes per caratteri fine linea
* 7c2feb5 aggiunto gitignore per file .class
* 00e2d56 aggiunto e aggiornato file HelloWorld.java

notare come HEAD sia il voluto 6220c38
git status
HEAD scollegato su 6220c38
File non tracciati:
  (usa "git add <file>..." per includere l'elemento fra quelli di cui verrà eseguito il commit)
	.DS_Store

non è stato aggiunto nulla al commit ma sono presenti file non tracciati (usa "git add" per tracciarli)