# doing it this way evaluates immediately
ARCHIVE!= printf 'archives/adventure-%s.jar' `date -I`

# javac -version prints to stderr for some reason
JAVA_VERSION!= javac -version 2>&1 | tr ' ' '\n'| tail -1

Main.class:
	javac -Xlint:all -g Main.java

manifest: Main.class
	echo 'Manifest-Version: 1.0' > manifest
	echo 'Created-By: $(JAVA_VERSION) (Oracle Corporation)' >> manifest
	echo 'Name: Adventure' >> manifest
	echo 'Permissions: sandbox' >> manifest
	echo 'Main-Class: Main' >> manifest
	echo "Sealed: true\n" >> manifest

archives:
	mkdir archives

$(ARCHIVE): archives Main.class manifest
	jar -cvfm archives/adventure-2017-11-20.jar manifest Main.* readonly/ adventure/
	jarsigner $(ARCHIVE) mykey

.PHONY: clean clobber backup run over

run: $(ARCHIVE)
	java -jar $(ARCHIVE)

clean:
	rm -f Main.class adventure/*.class readonly/*.class $(ARCHIVE) manifest

clobber: clean
	rm -rf archives

backup: $(ARCHIVE)

over: clean run

