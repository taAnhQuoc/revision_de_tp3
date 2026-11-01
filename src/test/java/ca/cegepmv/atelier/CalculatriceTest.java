package ca.cegepmv.atelier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Atelier — Tests unitaires
 * =========================
 *
 * Objectif : revoir les bases des tests unitaires avec JUnit 6 en complétant les tests
 * manquants (marqués TODO) sur la classe {@link Calculatrice}.
 *
 * Rappels de vocabulaire :
 * - Un "cas de test" (test case) = une seule méthode annotée @Test qui vérifie UN
 *   comportement précis.
 * - Une "suite de tests" (test suite) = l'ensemble des cas de test d'une classe
 *   (ici, toute la classe CalculatriceTest).
 * - Une "assertion" = un appel assertXxx(...) qui compare le résultat obtenu au résultat
 *   attendu. Si l'assertion échoue, le test échoue.
 * - Patron AAA : Arrange (préparer les données), Act (appeler la méthode testée),
 *   Assert (vérifier le résultat).
 *
 * Consigne : complétez chaque méthode marquée "// TODO" en suivant le patron AAA.
 * Ne modifiez pas les tests déjà fournis (niveau 1), ils servent d'exemple.
 */
class CalculatriceTest {

    private final Calculatrice calculatrice = new Calculatrice();

    // ------------------------------------------------------------------
    // Niveau 1 — Assertions simples (déjà fournis, à titre d'exemple)
    // ------------------------------------------------------------------

    @Test
    void additionnerDeuxNombresPositifs() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int resultat = calculatrice.additionner(a, b);

        // Assert
        assertEquals(5, resultat);
    }

    @Test
    void soustraireDonneLaDifference() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int resultat = calculatrice.soustraire(a, b);

        // Assert
        assertEquals(6, resultat);
    }

    // ------------------------------------------------------------------
    // Niveau 1 — À vous de jouer (suivez le même modèle que ci-dessus)
    // ------------------------------------------------------------------

    @Test
    void multiplierDeuxNombres() {
        // TODO: Arrange - Act - Assert
        int a = 4;
        int b = 5;

        int resultat = calculatrice.multiplier(a, b);
        // Vérifiez que multiplier(4, 5) retourne 20
        assertEquals(20, resultat);
    }

    @Test
    void maxRetourneLePlusGrandDesDeuxNombres() {
        // TODO: Arrange - Act - Assert
        // Vérifiez que max(7, 3) retourne 7
        int a = 7;
        int b = 3;

        int resultat = calculatrice.max(a, b);

        assertEquals(7, resultat);
    }

    // ------------------------------------------------------------------
    // Niveau 2 — Comportements composés (assertAll, assertThrows)
    // ------------------------------------------------------------------

    @Test
    void estPairDistingueLesNombresPairsEtImpairs() {
        // TODO: utilisez assertAll(...) pour vérifier PLUSIEURS assertions dans un seul test :
        //  - estPair(4) doit être vrai
        //  - estPair(7) doit être faux
        //  - estPair(0) doit être vrai
        boolean a = calculatrice.estPair(4);
        boolean b = calculatrice.estPair(7);
        boolean c = calculatrice.estPair(0);


        assertAll("Le nombre est pair ou pas",
            () -> assertEquals(true, a),
            () -> assertEquals(false, b),
            () -> assertEquals(true, c)
        );
    }

    @Test
    void diviserParZeroLanceUneException() {
        // TODO: utilisez assertThrows(ArithmeticException.class, () -> ...)
        // pour vérifier que diviser(10, 0) lance bien une ArithmeticException.
        int a = 10;
        int b = 0;

        assertThrows(ArithmeticException.class, () -> calculatrice.diviser(a, b));
    }

    // ------------------------------------------------------------------
    // Niveau 3 — Tests paramétrés (@ValueSource / @CsvSource) et cas limites
    // ------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    void estPremierRetourneVraiPourLesNombresPremiersConnus(int nombre) {
        // TODO: Act + Assert
        // Vérifiez que estPremier(nombre) retourne true pour chacune des valeurs fournies.
        boolean resultat = calculatrice.estPremier(nombre);

        assertEquals(true, resultat);
        
    }

    @ParameterizedTest
    @CsvSource({
        "1, false",   // 1 n'est pas premier par définition
        "4, false",   // 4 = 2 x 2
        "9, false",   // 9 = 3 x 3
        "17, true"    // 17 est premier
    })
    void estPremierGereLesCasLimites(int nombre, boolean attendu) {
        // TODO: Act + Assert
        // Vérifiez que estPremier(nombre) correspond bien à la valeur "attendu".
        boolean resultat = calculatrice.estPremier(nombre);

        assertEquals(attendu, resultat);
    }

    @Test
    void diviserAvecNombresNegatifs() {
        // TODO: Arrange - Act - Assert
        // Cas limite : que se passe-t-il quand on divise un nombre négatif ?
        // Vérifiez que diviser(-10, 2) retourne -5.
        int a = -10;
        int b = 2;

        int resultat = calculatrice.diviser(a, b);

        assertEquals(-5, resultat);
    }
}
