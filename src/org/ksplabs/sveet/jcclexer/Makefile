JAVACC_DIR=~/NetBeansProjects/javacc-5.0/bin

JAVACC=$(JAVACC_DIR)/javacc
JJDOC=$(JAVACC_DIR)/jjdoc
JJRUN=$(JAVACC_DIR)/jjrun
JJTREE=$(JAVACC_DIR)/jjtree

gen:
	$(JAVACC) SV.jj

doc:
	$(JJDOC) SV.jj

clean:
	rm -f ./*.java ./*.html