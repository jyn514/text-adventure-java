# doing it this way evaluates immediately
ARCHIVE!= printf 'archives/adventure-%s.jar' `date -I`

# javac -version prints to stderr for some reason
JAVA_VERSION!= javac -version 2>&1 | tr ' ' '\n'| tail -1

SOURCE_FILES = Main.java adventure/Adventure.java adventure/Character.java adventure/Command.java adventure/Item.java adventure/Location.java adventure/Room.java readonly/Functions.java readonly/Mappings.java readonly/NotImplementedException.java readonly/Printing.java readonly/StringManipulation.java

CLASS_FILES = Main.class adventure/Adventure.class adventure/Character.class adventure/Command.class adventure/Item.class adventure/Location.class adventure/Room.class readonly/Functions.class readonly/Mappings.class readonly/NotImplementedException.class readonly/Printing.class readonly/StringManipulation.class


Main.class: $(SOURCE_FILES)
	javac -Xlint:all -g Main.java

manifest: $(CLASS_FILES)
	echo 'Manifest-Version: 1.0' > manifest
	echo 'Created-By: $(JAVA_VERSION) (Oracle Corporation)' >> manifest
	echo 'Name: Adventure' >> manifest
	echo 'Permissions: sandbox' >> manifest
	#echo 'Trusted-Only: true' >> manifest
	echo 'Main-Class: Main' >> manifest
	#echo "Sealed: true\n" >> manifest

archives:
	mkdir archives

$(ARCHIVE): archives manifest $(CLASS_FILES) $(SOURCE_FILES)
	jar -cvfe $(ARCHIVE) Main $(CLASS_FILES) $(SOURCE_FILES)
	#jarsigner $(ARCHIVE) mykey

.PHONY: clean clobber backup all run over

run: $(ARCHIVE)
	java -jar $(ARCHIVE)

clean:
	rm -f $(CLASS_FILES)

clobber: clean
	rm -rf archives
	rm -f manifest

backup: $(ARCHIVE)

over: clean Main.class
