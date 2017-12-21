JAVACC_DIR=/Users/kpankov/NetBeansProjects/javacc-5.0/bin

JAVACC=$(JAVACC_DIR)/javacc
JJDOC=$(JAVACC_DIR)/jjdoc
JJRUN=$(JAVACC_DIR)/jjrun
JJTREE=$(JAVACC_DIR)/jjtree

gen:
	$(JAVACC) Java1.5.jj

doc:
	$(JJDOC) Java1.5.jj

clean:
	rm -f ./*.java ./*.html