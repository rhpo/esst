<script>
    import { onMount } from "svelte";

    let title = "CONTRAT DE DÉVELOPPEMENT DE LOGICIEL";
    let prestataire = {
        name: "TechNova Solutions SARL",
        address: "25 Rue Didouche Mourad, Alger",
        rep: "M. Karim Benali",
    };
    let client = {
        name: "OptiCom Services EURL",
        address: "Zone Industrielle, Oran",
        rep: "Mme Leïla Hamdani",
    };
    let contractDate = new Date().toLocaleDateString("fr-FR");
    let objet =
        "Le présent contrat a pour objet la conception, le développement et la livraison d’un logiciel métier personnalisé pour le Client, conformément aux spécifications fonctionnelles détaillées dans le cahier des charges annexé au présent contrat.";
    let amount = "3 600 000 DZD";
    let filename = "contrat_developpement_logiciel.pdf";

    let articles = [
        {
            id: 1,
            title: "Description du projet",
            body: "Le Prestataire s’engage à concevoir un logiciel de gestion interne destiné à automatiser les processus de facturation, de suivi client et de génération de rapports pour le Client. Le développement comprendra les modules suivants : gestion des utilisateurs, base de données clients, génération de documents PDF et tableau de bord d’analyse.",
        },
        {
            id: 2,
            title: "Obligations du Prestataire",
            body: "Le Prestataire s’engage à : Concevoir et développer le logiciel conformément au cahier des charges validé. Effectuer les tests de validation avant la livraison. Assurer la formation du personnel du Client à l’utilisation du logiciel. Fournir une assistance technique pendant une période de trois (3) mois après la livraison finale.",
        },
        {
            id: 3,
            title: "Obligations du Client",
            body: "Le Client s’engage à : Fournir au Prestataire toutes les informations nécessaires à la bonne exécution du projet. Valider les livrables intermédiaires dans les délais convenus. Régler les paiements conformément aux modalités prévues à l’article 6.",
        },
        {
            id: 4,
            title: "Délai d’exécution",
            body: "La durée totale du projet est fixée à quatre (4) mois à compter de la signature du présent contrat. Tout retard dû à une cause imputable au Client entraînera une prolongation équivalente du délai.",
        },
        {
            id: 5,
            title: "Conditions financières",
            body: "Le montant global du contrat est fixé à 3 600 000 DZD, réparti comme suit : 30 % à la signature du contrat (acompte) ; 40 % à la livraison de la version bêta ; 30 % à la réception définitive du logiciel. Les paiements seront effectués par virement bancaire au compte du Prestataire indiqué sur la facture.",
        },
        {
            id: 6,
            title: "Propriété intellectuelle",
            body: "Le Prestataire reste propriétaire de ses outils, méthodes, bibliothèques et composants réutilisables. Le Client devient propriétaire exclusif du logiciel final livré, sous réserve du paiement intégral du prix convenu.",
        },
        {
            id: 7,
            title: "Confidentialité",
            body: "Chaque partie s’engage à conserver strictement confidentielles les informations échangées dans le cadre du présent contrat et à ne pas les divulguer sans l’accord préalable écrit de l’autre partie.",
        },
        {
            id: 8,
            title: "Garantie et maintenance",
            body: "Le Prestataire garantit le bon fonctionnement du logiciel pendant une période de trois (3) mois à compter de sa réception. Pendant cette période, toute anomalie signalée sera corrigée sans frais supplémentaires. Une offre de maintenance annuelle pourra être proposée séparément.",
        },
        {
            id: 9,
            title: "Article : Résiliation",
            body: "En cas d’inexécution grave de ses obligations par l’une des parties, l’autre partie pourra résilier le présent contrat après une mise en demeure restée sans effet pendant quinze (15) jours.",
        },
        {
            id: 10,
            title: "Article : Force majeure",
            body: "Aucune des parties ne pourra être tenue responsable d’un retard ou d’une inexécution résultant d’un cas de force majeure au sens de la législation algérienne en vigueur.",
        },
        {
            id: 11,
            title: "Article : Litiges et juridiction compétente",
            body: "Tout différend relatif à l’interprétation ou à l’exécution du présent contrat sera soumis aux tribunaux compétents d’Alger, après tentative de résolution amiable.",
        },
    ];

    let nextId = articles.length + 1;

    function addArticle() {
        articles = [
            ...articles,
            {
                id: nextId++,
                title: `Article ${articles.length + 1} : Titre`,
                body: "Corps de l'article...",
            },
        ];
    }

    function removeArticle(id) {
        articles = articles.filter((a) => a.id !== id);
    }

    // Validation
    let errors = {};

    function validate() {
        errors = {};

        if (!objet.trim()) errors.objet = "Ce champ est obligatiore";

        if (!title.trim()) errors.title = "Ce champ est obligatoire";
        if (!contractDate.trim())
            errors.contractDate = "Ce champ est obligatoire";

        if (!prestataire.name.trim())
            errors.prestataireName = "Ce champ est obligatoire";
        if (!prestataire.address.trim())
            errors.prestataireAddress = "Ce champ est obligatoire";
        if (!prestataire.rep.trim())
            errors.prestataireRep = "Ce champ est obligatoire";

        if (!client.name.trim()) errors.clientName = "Ce champ est obligatoire";
        if (!client.address.trim())
            errors.clientAddress = "Ce champ est obligatoire";
        if (!client.rep.trim()) errors.clientRep = "Ce champ est obligatoire";

        if (!amount.trim()) errors.amount = "Ce champ est obligatoire";
        if (!filename.trim()) errors.filename = "Ce champ est obligatoire";

        if (articles.length <= 0)
            errors.articles = "Au moins un article est requis";

        articles.forEach((a, i) => {
            if (!a.title.trim())
                errors[`articleTitle${i}`] = "Titre obligatoire";
            if (!a.body.trim())
                errors[`articleBody${i}`] = "Contenu obligatoire";
        });

        return Object.keys(errors).length === 0;
    }

    $: if (errors) validate();

    let html2canvasLoaded = false;
    let jsPDFLoaded = false;

    function loadLibs() {
        return new Promise((resolve, reject) => {
            if (!html2canvasLoaded) {
                const s = document.createElement("script");
                s.src =
                    "https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js";
                s.onload = () => {
                    html2canvasLoaded = true;
                    if (jsPDFLoaded) resolve();
                };
                s.onerror = reject;
                document.head.appendChild(s);
            }
            if (!jsPDFLoaded) {
                const s2 = document.createElement("script");
                s2.src =
                    "https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js";
                s2.onload = () => {
                    jsPDFLoaded = true;
                    if (html2canvasLoaded) resolve();
                };
                s2.onerror = reject;
                document.head.appendChild(s2);
            }
            if (html2canvasLoaded && jsPDFLoaded) resolve();
        });
    }

    async function exportPDF() {
        if (!validate()) {
            alert("Veuillez corriger les erreurs avant d’exporter le PDF.");
            return;
        }

        try {
            await loadLibs();
            const contractEl = document.getElementById("contract");
            const opts = { scale: 2, useCORS: true };
            const canvas = await window.html2canvas(contractEl, opts);
            const imgData = canvas.toDataURL("image/png");

            const { jsPDF } = window.jspdf;
            const pdf = new jsPDF("p", "mm", "a4");
            const pageWidth = pdf.internal.pageSize.getWidth();
            const pageHeight = pdf.internal.pageSize.getHeight();
            const margin = 10;
            const pdfWidth = pageWidth - margin * 2;
            const imgProps = pdf.getImageProperties(imgData);
            const imgWidth = imgProps.width;
            const imgHeight = imgProps.height;
            const ratio = imgHeight / imgWidth;
            const pdfImgHeight = pdfWidth * ratio;

            let heightLeft = pdfImgHeight;
            let position = margin;

            pdf.addImage(
                imgData,
                "PNG",
                margin,
                position,
                pdfWidth,
                pdfImgHeight,
            );
            heightLeft -= pageHeight - margin * 2;

            while (heightLeft > 0) {
                pdf.addPage();
                position = -(pdfImgHeight - heightLeft) + margin;
                pdf.addImage(
                    imgData,
                    "PNG",
                    margin,
                    position,
                    pdfWidth,
                    pdfImgHeight,
                );
                heightLeft -= pageHeight - margin * 2;
            }

            pdf.save(filename);
        } catch (err) {
            alert("Erreur lors de la génération du PDF : " + err.message);
            console.error(err);
        }
    }

    onMount(() => {});
</script>

<div class="app">
    <div class="editor">
        <h3>Éditeur</h3>

        <label
            >Titre du contrat {#if errors.title}<span class="error"
                    >{errors.title}</span
                >{/if}</label
        >
        <input bind:value={title} />

        <label
            >Date {#if errors.contractDate}<span class="error"
                    >{errors.contractDate}</span
                >{/if}</label
        >
        <input bind:value={contractDate} />

        <h4>Prestataire</h4>
        <label
            >Nom {#if errors.prestataireName}<span class="error"
                    >{errors.prestataireName}</span
                >{/if}</label
        >
        <input bind:value={prestataire.name} placeholder="Nom" />

        <label
            >Adresse {#if errors.prestataireAddress}<span class="error"
                    >{errors.prestataireAddress}</span
                >{/if}</label
        >
        <input bind:value={prestataire.address} placeholder="Adresse" />

        <label
            >Représentant {#if errors.prestataireRep}<span class="error"
                    >{errors.prestataireRep}</span
                >{/if}</label
        >
        <input bind:value={prestataire.rep} placeholder="Représentant" />

        <h4>Client</h4>
        <label
            >Nom {#if errors.clientName}<span class="error"
                    >{errors.clientName}</span
                >{/if}</label
        >
        <input bind:value={client.name} placeholder="Nom" />

        <label
            >Adresse {#if errors.clientAddress}<span class="error"
                    >{errors.clientAddress}</span
                >{/if}</label
        >
        <input bind:value={client.address} placeholder="Adresse" />

        <label
            >Représentant {#if errors.clientRep}<span class="error"
                    >{errors.clientRep}</span
                >{/if}</label
        >
        <input bind:value={client.rep} placeholder="Représentant" />

        <h4>Objet du contrat</h4>
        <label>
            {#if errors.objet}<span class="error">{errors.objet}</span>{/if}
        </label>
        <textarea
            rows="3"
            bind:value={objet}
            placeholder="Décrivez l'objet du contrat..."
        ></textarea>

        <h4>
            Articles {#if articles.length === 0}<span class="error"
                    >Veuillez entrer au moins un article.</span
                >{/if}
        </h4>
        {#if articles.length <= 0}{:else}
            {#each articles as art, i (art.id)}
                <div class="article">
                    <label
                        >{art.title}
                        {#if errors[`articleTitle${i}`]}<span class="error"
                                >{errors[`articleTitle${i}`]}</span
                            >{/if}
                    </label>
                    <input bind:value={art.title} />

                    <label
                        >Contenu
                        {#if errors[`articleBody${i}`]}<span class="error"
                                >{errors[`articleBody${i}`]}</span
                            >{/if}
                    </label>
                    <textarea rows="4" bind:value={art.body}></textarea>
                    <div style="display:flex;justify-content:flex-end;">
                        <button on:click={() => removeArticle(art.id)}
                            >Supprimer</button
                        >
                    </div>
                </div>
            {/each}
        {/if}

        <div style="display:flex;gap:8px;">
            <button on:click={addArticle}>Ajouter un article</button>
        </div>

        <h4>Export</h4>
        <label
            >Nom du fichier {#if errors.filename}<span class="error"
                    >{errors.filename}</span
                >{/if}</label
        >
        <input bind:value={filename} />

        <label
            >Montant {#if errors.amount}<span class="error"
                    >{errors.amount}</span
                >{/if}</label
        >
        <input bind:value={amount} />

        <div>
            <button
                on:click={exportPDF}
                disabled={!validate() || articles.length <= 0}
                >Exporter en PDF</button
            >
        </div>
    </div>

    <div class="preview">
        <h3>Aperçu</h3>
        <div id="contract" style="box-shadow:0 0 0 1px #ccc;">
            <h1>{title}</h1>
            <div style="text-align:right;">Fait le : {contractDate}</div>

            <p>
                Entre les soussignés :<br />
                <strong>{prestataire.name}</strong><br />
                {prestataire.address}<br />
                Représenté par : {prestataire.rep}
            </p>

            <p>
                Et<br />
                <strong>{client.name}</strong><br />
                {client.address}<br />
                Représenté par : {client.rep}
            </p>

            <h4 style="margin-bottom:  0">
                <strong>Objet du contrat :</strong><br />
            </h4>

            {objet}

            <hr />

            {#each articles as art, i}
                <h4 style="margin-bottom:6px">
                    {`Article ${i + 1} : ` + art.title}
                </h4>
                <p style="white-space:pre-wrap;">{art.body}</p>
            {/each}

            <hr />

            <p><strong>Montant :</strong> {amount}</p>

            <div class="sign">
                <div>
                    <p><strong>Pour le Prestataire</strong></p>
                    <p>{prestataire.name}</p>
                    <canvas
                        id="signatureCanvas"
                        width="250"
                        height="80"
                        style="border:1px solid #ccc;border-radius:6px;cursor:crosshair;"
                        on:mousedown={(e) => {
                            const c = e.target;
                            const ctx = c.getContext("2d");
                            let drawing = true;
                            ctx.beginPath();
                            const move = (ev) => {
                                if (!drawing) return;
                                const rect = c.getBoundingClientRect();
                                ctx.lineWidth = 2;
                                ctx.lineCap = "round";
                                ctx.strokeStyle = "#000";
                                ctx.lineTo(
                                    ev.clientX - rect.left,
                                    ev.clientY - rect.top,
                                );
                                ctx.stroke();
                                ctx.beginPath();
                                ctx.moveTo(
                                    ev.clientX - rect.left,
                                    ev.clientY - rect.top,
                                );
                            };
                            const stop = () => {
                                drawing = false;
                                c.removeEventListener("mousemove", move);
                                c.removeEventListener("mouseup", stop);
                                c.removeEventListener("mouseleave", stop);
                            };
                            c.addEventListener("mousemove", move);
                            c.addEventListener("mouseup", stop);
                            c.addEventListener("mouseleave", stop);
                        }}
                    ></canvas>
                    <button
                        class="no-pdf"
                        on:click={() => {
                            const c =
                                document.getElementById("signatureCanvas");
                            c.getContext("2d").clearRect(
                                0,
                                0,
                                c.width,
                                c.height,
                            );
                        }}
                        style="font-size:12px;color:#555;margin-top:4px;"
                    >
                        Effacer la signature
                    </button>
                </div>
            </div>
            <div>
                <p><strong>Pour le Client</strong></p>
                <p>{client.name}</p>
                <div
                    style="border:1px dashed #ccc;width:250px;height:80px;border-radius:6px;display:flex;align-items:center;justify-content:center;color:#999;"
                >
                    (Signature à compléter)
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    @media print {
        .no-pdf {
            display: none !important;
        }
    }

    :global(body) {
        font-family:
            system-ui,
            -apple-system,
            "Segoe UI",
            Roboto,
            "Helvetica Neue",
            Arial;
    }

    .app {
        display: flex;
        gap: 20px;
        padding: 16px;
    }

    .editor {
        width: 420px;
        height: fit-content;
        overflow: auto;
        border: 1px solid #e6e6e6;
        padding: 12px;
        border-radius: 8px;
    }

    .preview {
        flex: 1;
        border: 1px solid #e6e6e6;
        padding: 20px;
        border-radius: 8px;
        background: white;
    }

    input,
    textarea {
        width: 100%;
        padding: 8px;
        margin: 6px 0;
        box-sizing: border-box;
    }

    button {
        padding: 8px 12px;
        margin: 6px 4px;
    }

    button:disabled {
        background: #ccc;
        cursor: not-allowed;
    }

    .article {
        border: 1px dashed #ddd;
        padding: 8px;
        margin-bottom: 8px;
        border-radius: 6px;
    }

    #contract {
        width: 794px;
        padding: 24px;
        background: white;
        color: #000;
    }

    h1 {
        text-align: center;
        font-size: 18px;
        margin-bottom: 8px;
    }

    .sign {
        margin-top: 40px;
        display: flex;
        justify-content: space-between;
    }

    .error {
        color: red;
        font-size: 12px;
        margin-left: 6px;
    }
</style>
